package server;

import act.Reply;
import act.Request;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.logging.Logger;

public class Server {

    private static final Logger logger = Logger.getAnonymousLogger();

    private static final int PORT = 9000;
    private static final int BUF_SIZE = 32768;
    private static DatagramChannel channel;

    static { //  Статический блок, вызывается при инициализации класса
        try{
            channel = DatagramChannel.open(); //  Открыли канал
            channel.bind(new InetSocketAddress(PORT)); //  Привязали канал к порту
            channel.configureBlocking(false); //  Неблокирующий режим
            logger.info("Сервер начал свою работу");
        } catch (IOException ex){
            System.out.println("Сервер не может быть запущен.");
        }
    }

    public Request recieve(){
        try {
            ByteBuffer buffer = ByteBuffer.allocate(BUF_SIZE); //  Буфер, в который пишется входной поток байтов
            SocketAddress clientAddress = channel.receive(buffer); //  Адрес возврата

            if (clientAddress == null){
                return null;
            }
            logger.info("Получен новый запрос от клиента: " + clientAddress);

            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(buffer.array())); //  Для десереализации
            Request request = (Request) ois.readObject();
            request.setClientAdress(clientAddress);

            return request;
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("Запрос получен неверно.");;
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("Невозможно восстановить класс объекта.");;
            return null;
        }
    }

    public static void send(Reply reply, SocketAddress clientAdress){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try{

            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(reply);
            channel.send(ByteBuffer.wrap(baos.toByteArray()), clientAdress);
            logger.info("Ответ отправлен клиенту: " + clientAdress);

        } catch (IOException e) {
            System.out.println("Ошибка отправки данных клиенту.");;
        }
    }

}

package data;

public enum Leader {

    PERVIY("Первая персона"),
    VTOROY("Вторая важная персона"),
    TRETIY("Третья очень важная персона"),
    CHETVYRTIY("Просто четвёртая персона"),
    PYTIY("Пятый человек");

    private final String title;

    Leader(String title){
        this.title = title;
    }

    @Override
    public String toString() { return title;}

}


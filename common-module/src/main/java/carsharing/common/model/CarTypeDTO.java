package carsharing.common.model;

public enum CarTypeDTO {

    SEDAN("Седан"),
    HATCHBACK("Хэтчбек"),
    CROSSOVER("Кроссовер"),
    SUV("Внедорожник"),
    MINIVAN("Минивэн"),
    COUPE("Купе"),
    SPORT_CAR("Спорткар"),
    ELECTRIC("Электромобиль"),
    HYBRID("Гибрид"),
    PICKUP("Пикап");

    private final String description;

    CarTypeDTO(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

package de.bcxp.school.devops.troubleshooting.presents;

import java.util.Random;

public class ChristmasPresentGenerator {

    private static final String[] ADJECTIVES = {"Glowing", "Gigantic", "Mysterious", "Dazzling", "Awesome", "Brilliant", "Fantastic", "Incredible", "Superb", "Magical",
            "Sparkling", "Enchanting", "Adorable", "Charming", "Delightful", "Elegant", "Graceful", "Radiant", "Stunning", "Wonderful"};

    private static final String[] NOUNS = {"Robot", "Spaceship", "Dinosaur", "Adventure", "Superhero", "Racecar", "Gadget", "Treasure", "Puzzle", "Game",
            "Princess", "Unicorn", "Fairy", "Doll", "Jewelry", "Castle", "Mermaid", "Rainbow", "Ballet", "Tea Party"};

    private static final Random random = new Random();

    public String generatePresentName() {
        String adjective = getRandomElement(ADJECTIVES);
        String noun = getRandomElement(NOUNS);
        return adjective + " " + noun;
    }

    private static String getRandomElement(String[] array) {
        int index = random.nextInt(array.length);
        return array[index];
    }

}

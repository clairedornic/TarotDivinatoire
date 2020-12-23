package gameInterface;

import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Deck;

public class AddClassicCardsPanel extends JPanel {

    private static final long serialVersionUID = 11L;
    final String[] names = { "Magician", "Priestess", "Empress", "Emperor", "Hierophant", "Lovers", "Chariot", "Justice",
        "Hermit", "Wheel of fortune", "Strength", "Hanged Man", "Death", "Temperance", "Devil", "Tower",
        "Star", "Moon", "Sun", "Judgement", "World", "Fool" };
    final int[] theId = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22 };
    final String[] descs = { "The Magician always has an infinity symbol over his head. He is the planet Mercury, the messenger. The Magician represents meaning, mastering your imagination, conscious and unconscious processes.", 
                            "The High Priestess symbolizes intuition, psychic energy, the dream world, the unconscious, feelings, instincts and emotions. She senses what is going on below the surface. She is a receptive mirror. She relates to women’s cycles, magic, the womb, fertility. She connects you to your instinctual powers.", 
                            "She is the Goddess, the Great Mother. She symbolizes the planet Venus, Goddess of love, beauty, fertility and relationships. She also indicates money, peacemaking and the arts. She is traditionally shown as a pregnant woman. She represents your mother and relationships with other women.", 
                            "He is the King and head honcho. He symbolizes masculine creativity. He represents authority, power, responsibility, leadership, passion and action, and is seen as a symbol of sex, the warrior and defender. He symbolizes new beginnings, competition and aggression. He can represent the father, husband, man in your life, boss, or any authority figure. ", 
                            "The Hierophant symbolizes a spiritual authority  who connects with god/your guardian angel/ higher self directly. He symbolizes grounded, practical wisdom and energy. ", 
                            "This is the card everyone loves to get. Not always the golden key to all relationships, it also indicates choices. We all have an internal masculine and feminine side which must be balanced in order to find love. Symbolized by the six pointed star, the Lovers represents heaven and earth, union, love, communication, balance, and duality.", 
                            "This symbolizes the emotional body. It is also the womb, through which everyone enters the world.  The Chariot symbolizes victory through controlling your emotions. It also relates to the home, family, needing emotional protection, your mother, nurturing, caring and nourishment. ", 
                            " The Scales are karmic justice. They indicate a need for balance and discernment. This card relates to relationships, finding peace, self and others, marriage.", 
                            "The Hermit is a symbol of inner knowledge. The need to be alone to tune in and listen to your gut instincts. It’s the perfectionist, symbolizes humility, service, devoted to the earth, health, discipline and the body. It is intelligent, analytical and self-critical. ", 
                            "This card has nothing to do with game shows. It is the wheel of karma and time. It’s optimistic and fortunate. It is an acceleration of learning, and represents generosity, freedom and taking risks. It is lucky, but can mean too much of a good thing. ",
                            "As Strength, the woman has an infinity symbol over her head. This card is a master number, symbolizing memory. It means conquering your animal instincts. It also symbolizes the courage in your heart.", 
                            "Most people want to turn this card around in the opposite direction. The Hanged Man is a very powerful archetype. He symbolizes letting go, surrendering the ego, turning everything you knew upside down. It also indicate scapegoating and martyrdom. ", 
                            "This is the card that always scares people. It’s a very positive card and rarely means someone is going to die. It symbolizes ego death, change, rebirth and transformation. Everything in life is always dying and being reborn. It relates to power, control, the unconscious, psychology, sexuality and fear. ", 
                            "This is a very powerful symbol. After death, the self is transmuted and tempered by the temperance angel into something new—the card of balance. This card symbolizes the soulmate, the divine lovers and alchemy. It represents optimism, higher knowledge, wisdom and truth. ", 
                            "This is another card which also strikes fear into neophytes because The Devil is fear itself. The Devil is illusion, greed, temptation, the material world. It symbolizes your demons, your projections onto and from others. The Devil is your shadow, dark side and unconscious. It is phallic, sexual, and wild energy. It can symbolize your boss or any authority figures. ", 
                            "This symbolizes the old structure of your lower self and false ego being destroyed. Your life has to fall apart, the old ways must go, as a necessary process to awakening. The Tower brings sudden, shocking awareness. It is the opening of the third eye. It can also symbolize accidents and losses. ", 
                            "When you wish upon a star, literally. This card symbolizes cosmic inspiration, higher consciousness, being a vessel of universal intelligence, humanitarian awareness, individuality, freedom, co-operation. As a symbol of Aquarius, it brings detachment, inventiveness and pioneering energies, connecting you to astrology, your tribe and ancestors. ", 
                            "This card symbolizes the dark side of the moon and the unconscious realms. This is the dark night of the soul. This is a card of fear and facing the unknown. Have faith and trust, knowing that there is light at the end of the tunnel. It means relying on your intuition and working with your dreams. ", 
                            "This is the journey back to the source. It represents living in the light, positive energy, warmth, happiness, joy, dancing, celebration, ecstasy. Whatever you had to go through it was worth it, because with this card, a childlike innocence is regained. ", 
                            "This is the symbol of rebirth. The only judgements are those we create ourselves. It’s a symbol of resurrection, change, freedom from the past, and grace. ", 
                            "The end of the trail, the completion of the journey. This card represents coming back into the world, grounding, seeing reality for what it is. It symbolizes that by taking responsibility for creating everything in your life. It’s the end of a cycle. It represents the real everyday world. ",
                            "The first time anyone has their first tarot reading they are considered to embody The Fool. Don’t laugh. The Fool is the wisest one, who knows everything. It symbolizes the eternal soul and is the symbol of enlightenment. The Fool is the first and last trump in the deck. It symbolizes a brand new cycle, trust, innocence, the inner child." };
    final String[] pathsImg = { "src\\img\\1-bateleur.jpg", "src\\img\\2-papesse.jpg", "src\\img\\3-imperatrice.jpg", "src\\img\\4-empereur.jpg", "src\\img\\5-pape.jpg", "src\\img\\6-amoureux.jpg", "src\\img\\7-chariot.jpg", "src\\img\\8-justice.jpg", "src\\img\\9-hermite.jpg",
        "src\\img\\10-roue-fortune.jpg", "src\\img\\11-force.jpg", "src\\img\\12-pendu.jpg", "src\\img\\13-mort.jpg", "src\\img\\14-temperance.jpg", "src\\img\\15-diable.jpg", "src\\img\\16-maison-dieu.jpg", "src\\img\\17-etoile.jpg", "src\\img\\18-lune.jpg", "src\\img\\19-soleil.jpg", "src\\img\\20-jugement.jpg",
        "src\\img\\21-monde.jpg", "src\\img\\22-mat.jpg" }; 
    JLabel test;
    Deck userDeck;
    
    public AddClassicCardsPanel(Deck deckUser){
        this.userDeck = deckUser;
        for (int n = 0; n < names.length; n++) {
            String name = names[n];
            int id = theId[n];
            String desc = descs[n];
            String pathImg = pathsImg[n];
            userDeck.addCompleteCardToDeck(name, id, desc, pathImg);
          }
          panelElements();
    }

    /** 
    * 
	* Create and add components to the main Panel
    *
	*/
 
    private void panelElements() {
        JLabel empty;
        JLabel noEmpty;
        if (userDeck.isEmpty() == true)  {
            empty = new JLabel("Classic cards have not been added to the deck.");
            this.add(empty);
        } else {
            noEmpty = new JLabel("Classic cards have been added to your deck!");
            this.add(noEmpty);
        }
    }
}

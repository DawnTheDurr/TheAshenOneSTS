package Ashen;

import Ashen.cards.Defend_Ash;
import Ashen.cards.Strike_Ash;
import Ashen.character.TheAshen;
import Ashen.patch.ClassEnum;
import Ashen.relics.Darksign;
import Ashen.relics.Hollow;
import basemod.BaseMod;
import basemod.ModPanel;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditCharactersSubscriber;
import basemod.interfaces.EditRelicsSubscriber;
import basemod.interfaces.PostInitializeSubscriber;
import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.helpers.CardHelper;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import java.util.ArrayList;

import static Ashen.patch.CardEnum.THE_ASHEN_ONE_COLOR;

@SpireInitializer

public class Ashen implements EditCharactersSubscriber, PostInitializeSubscriber,
        EditCardsSubscriber, EditRelicsSubscriber {

    public static final Color SOULS = CardHelper.getColor(60f, 26f, 81f);

    private static final String ASHEN_BUTTON = "images/ui/testButton.png";
    private static final String ASHEN_PORTRAIT = "images/char/ironcladPortrait.png";

    private static final String ATTACK = "images/cards/portrait/atk.png";
    private static final String SKILL = "images/cards/portrait/skill.png";
    private static final String POWER = "images/cards/portrait/pow.png";
    private static final String ENERGY = "images/cards/portrait/orb.png";

    private static final String ATTACK_PORT = "images/cards/portrait/atkPort.png";
    private static final String SKILL_PORT = "images/cards/portrait/skillPort.png";
    private static final String POWER_PORT = "images/cards/portrait/powPort.png";
    private static final String ENERGY_PORT = "images/cards/portrait/orbPort";

    private static final String ENERGY_ORB = "images/cards/portrait/orb.png";

    private ArrayList<AbstractCard> cardList = new ArrayList<>();
    private ArrayList<AbstractRelic> relicList = new ArrayList<>();

    public Ashen(){
        BaseMod.subscribe(this);
        BaseMod.addColor(THE_ASHEN_ONE_COLOR,
                SOULS, SOULS, SOULS, SOULS, SOULS, SOULS, SOULS,
                ATTACK, SKILL, POWER, ENERGY,
                ATTACK_PORT, SKILL_PORT, POWER_PORT, ENERGY_PORT,
                ENERGY_ORB);
    }

    public static void initialize(){
        new Ashen();
    }

    @Override
    public void receiveEditCharacters() {
        BaseMod.addCharacter(new TheAshen("Ashen"),
                ASHEN_BUTTON, ASHEN_PORTRAIT,
                ClassEnum.THE_ASHEN_CLASS);
    }

    @Override
    public void receivePostInitialize() {
        ModPanel modPanel = new ModPanel();
    }

    private void createCardList(){
        cardList.clear();

        cardList.add(new Strike_Ash());
        cardList.add(new Defend_Ash());
    }

    @Override
    public void receiveEditCards() {

        createCardList();

        for (AbstractCard c: cardList){
            BaseMod.addCard(c);
        }
    }

    private void createCustRelicList(){
        relicList.clear();

        relicList.add(new Darksign());
        relicList.add(new Hollow());
    }

    @Override
    public void receiveEditRelics() {

        createCustRelicList();

        for (AbstractRelic r: relicList){
            BaseMod.addRelicToCustomPool(r, THE_ASHEN_ONE_COLOR);
        }
    }
}

package Ashen;

import Ashen.character.TheAshen;
import Ashen.patch.ClassEnum;
import basemod.BaseMod;
import basemod.ModPanel;
import basemod.interfaces.EditCharactersSubscriber;
import basemod.interfaces.PostInitializeSubscriber;
import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.helpers.CardHelper;

import static Ashen.patch.CardEnum.THE_ASHEN_ONE_COLOR;

@SpireInitializer

public class Ashen implements EditCharactersSubscriber, PostInitializeSubscriber {

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
}

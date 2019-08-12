package Ashen;

import Ashen.character.TheAshen;
import Ashen.patch.ClassEnum;
import basemod.BaseMod;
import basemod.interfaces.EditCharactersSubscriber;
import basemod.interfaces.PostBattleSubscriber;
import basemod.interfaces.PostDungeonInitializeSubscriber;
import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.CardHelper;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

import static Ashen.patch.CardEnum.THE_ASHEN_ONE_COLOR;

@SpireInitializer

public class Ashen implements PostBattleSubscriber, PostDungeonInitializeSubscriber, EditCharactersSubscriber {

    public static final Color SOULS = CardHelper.getColor(60f, 26f, 81f);

    public static final String ASHEN_BUTTON = "images/ui/testButton.png";
    public static final String ASHEN_PORTRAIT = "images/char/ironcladPortrait.png";

    public static final String ATTACK = "images/cards/portrait/atk.png";
    public static final String SKILL = "images/cards/portrait/skill.png";
    public static final String POWER = "images/cards/portrait/pow.png";
    public static final String ENERGY = "images/cards/portrait/orb.png";

    public static final String ATTACK_PORT = "images/cards/portrait/atkPort.png";
    public static final String SKILL_PORT = "images/cards/portrait/skillPort.png";
    public static final String POWER_PORT = "images/cards/portrait/powPort.png";
    public static final String ENERGY_PORT = "images/cards/portrait/orbPort";

    public static final String ENERGY_ORB = "images/cards/portrait/orb.png";

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
    public void receivePostBattle(AbstractRoom abstractRoom) {

    }

    @Override
    public void receivePostDungeonInitialize() {

    }

    @Override
    public void receiveEditCharacters() {
        BaseMod.addCharacter(new TheAshen(CardCrawlGame.playerName),
                ASHEN_BUTTON, ASHEN_PORTRAIT,
                ClassEnum.THE_ASHEN_CLASS);
    }
}

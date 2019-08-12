package Ashen.character;

import Ashen.Ashen;
import Ashen.patch.CardEnum;
import Ashen.patch.ClassEnum;
import basemod.abstracts.CustomPlayer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.red.Strike_Red;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.screens.CharSelectInfo;

import java.util.ArrayList;

public class TheAshen extends CustomPlayer {

    private static final int ENERGY_PER_TURN = 3;
    private static final String ASHEN_SHOULDER_2 = "images/char/shoulder2.png";
    private static final String ASHEN_SHOULDER_1 = "images/char/shoulder.png";
    private static final String ASHEN_CORPSE = "images/char/corpse.png";
    private static final String ASHEN_SKELETON_ATLAS = "images/char/skeleton.atlas";
    private static final String ASHEN_SKELETON_JSON = "images/char/skeleton.json";
    private static final String ASHEN = "images/char/ironcladPortrait.jpg";

    private static final String TITLE = "The Accursed";
    private static final String FLAVOUR = "An accursed undead, destined to become hollow";

    public TheAshen (String name){
        super(name, ClassEnum.THE_ASHEN_CLASS,null, null, null, null, null);

        this.dialogX = (this.drawX + 0.0F * Settings.scale);
        this.dialogY = (this.drawY + 220.0F * Settings.scale);

        this.initializeClass(ASHEN, ASHEN_SHOULDER_2,
                ASHEN_SHOULDER_1, ASHEN_CORPSE, getLoadout(),
                20.0F, -10.0F, 220.0F, 290.0F,
                new EnergyManager(ENERGY_PER_TURN));

        loadAnimation(ASHEN_SKELETON_ATLAS, ASHEN_SKELETON_JSON, 1.0F);
    }

    public ArrayList<String> getStartingDeck(){
        ArrayList<String> retVal = new ArrayList<>();
        retVal.add("Strike_Red");
        return retVal;
    }

    public ArrayList<String> getStartingRelics(){
        ArrayList<String> retVal = new ArrayList<>();
        return retVal;
    }

    private static final int STARTING_HP = 70;
    private static final int MAX_HP = 70;
    private static final int STARTING_GOLD = 99;
    private static final int HAND_SIZE = 5;

    public CharSelectInfo getLoadout(){
        return new CharSelectInfo(TITLE, FLAVOUR,
                STARTING_HP, MAX_HP, 0, STARTING_GOLD, HAND_SIZE,
                this, getStartingRelics(), getStartingDeck(), false);
    }

    public String getTitle(PlayerClass playerClass) {
        String title = "The Cursed Undead";
        return title;
    }

    public AbstractCard.CardColor getCardColor(){
        return CardEnum.THE_ASHEN_ONE_COLOR;
    }

    public Color getCardRenderColor() {
        return Ashen.SOULS;
    }

    public AbstractCard getStartCardForEvent() {
        return new Strike_Red();
    }

    public Color getCardTrailColor() {
        return Ashen.SOULS;
    }

    public int getAscensionMaxHPLoss() {
        return 0;
    }

    public BitmapFont getEnergyNumFont() {
        return new BitmapFont();
    }

    public void doCharSelectScreenSelectEffect() {}

    public String getCustomModeCharacterButtonSoundKey() {
        return null;
    }

    public String getLocalizedCharacterName() {
        return TITLE;
    }

    public AbstractPlayer newInstance() {
        return new TheAshen(this.name);
    }

    public String getSpireHeartText() {
        return "";
    }

    public Color getSlashAttackColor() {
        return Ashen.SOULS;
    }

    public AbstractGameAction.AttackEffect[] getSpireHeartSlashEffect() {
        return new AbstractGameAction.AttackEffect[0];
    }

    public String getVampireText() {
        return "";
    }

}

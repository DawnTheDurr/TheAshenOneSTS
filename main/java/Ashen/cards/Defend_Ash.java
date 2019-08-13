package Ashen.cards;

import Ashen.patch.CardEnum;
import basemod.abstracts.CustomCard;
import basemod.helpers.BaseModCardTags;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Defend_Ash extends CustomCard {

    public static final String ID = "Defend_Ash";
    //private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String NAME = "Defend";
    public static final String DESCRIP = "Basic Block";
    public static final String IMG = "images/cards/skills/defend.png";

    private static final int COST = 1;
    private static final int BLOCK = 5;
    private static final int UPGRADE_BLOCK = 3;

    public Defend_Ash(){
        super(ID, NAME, IMG, COST, DESCRIP,
                CardType.SKILL, CardEnum.THE_ASHEN_ONE_COLOR,
                CardRarity.BASIC, CardTarget.SELF);

        this.tags.add(BaseModCardTags.BASIC_DEFEND);
        this.baseBlock = BLOCK;
    }

    @Override
    public void upgrade() {
        if (!this.upgraded){
            upgradeName();
            upgradeBlock(UPGRADE_BLOCK);
        }
    }

    @Override
    public void use(AbstractPlayer plr, AbstractMonster mon) {
        AbstractDungeon.actionManager.addToBottom(
                new GainBlockAction(
                        plr, plr, this.block
                )
        );
    }
    @Override
    public boolean isDefend(){
        return true;
    }

    @Override
    public AbstractCard makeCopy(){
        return new Defend_Ash();
    }
}

package Ashen.cards;

import Ashen.patch.CardEnum;
import basemod.abstracts.CustomCard;
import basemod.helpers.BaseModCardTags;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Strike_Ash extends CustomCard {

    public static final String ID = "Strike_Ash";
    //private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String NAME = "Strike";
    public static final String DESCRIP = "Basic Attack";
    public static final String IMG = "images/cards/attacks/strike.png";

    private static final int COST = 1;
    private static final int DMG = 6;
    private static final int UPGRADE_DMG = 3;

    public Strike_Ash(){
        super(ID, NAME, IMG, COST, DESCRIP,
                CardType.ATTACK, CardEnum.THE_ASHEN_ONE_COLOR,
                CardRarity.BASIC, CardTarget.ENEMY);

        this.tags.add(BaseModCardTags.BASIC_STRIKE);
        this.baseDamage = DMG;
    }

    @Override
    public void upgrade() {
        if (!this.upgraded){
            upgradeName();
            upgradeDamage(UPGRADE_DMG);
        }
    }

    @Override
    public void use(AbstractPlayer plr, AbstractMonster mon) {
        AbstractDungeon.actionManager.addToBottom(
                new DamageAction(
                        mon, new DamageInfo(
                                plr, this.damage, this.damageTypeForTurn),
                        AbstractGameAction.AttackEffect.SLASH_DIAGONAL
                )
        );
    }

    @Override
    public boolean isStrike(){
        return true;
    }

    @Override
    public AbstractCard makeCopy(){
        return new Strike_Ash();
    }
}

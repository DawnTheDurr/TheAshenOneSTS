package Ashen.relics;

import basemod.abstracts.CustomRelic;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class Hollow extends CustomRelic {

    public static final String ID = "Hollow";
    public static final String IMG = "images/relics/Darksign.png";
    private boolean isActive = true;

    public Hollow(){
        super(ID, IMG, RelicTier.STARTER, LandingSound.MAGICAL);
    }

    @Override
    public void onObtainCard(AbstractCard c) {
        if (c.type == AbstractCard.CardType.CURSE && isActive){
            isActive = false; //Prevent infinite curse duplication
            c.makeCopy();
        } else if (!isActive){
            isActive = true;
        }
    }

    @Override
    public AbstractRelic makeCopy(){
        return new Hollow();
    }
}
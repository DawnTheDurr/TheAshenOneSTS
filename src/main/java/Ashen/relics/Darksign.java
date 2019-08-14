package Ashen.relics;

import basemod.abstracts.CustomRelic;
import com.evacipated.cardcrawl.mod.stslib.relics.OnPlayerDeathRelic;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.helpers.ImageMaster;


public class Darksign extends CustomRelic implements OnPlayerDeathRelic {

    public static final String ID = "Darksign";
    public static final String IMG = "images/relics/Darksign.png";

    public Darksign(){
        super(ID, ImageMaster.loadImage(IMG), RelicTier.STARTER, LandingSound.MAGICAL);
    }

    @Override
    public boolean onPlayerDeath(AbstractPlayer abstractPlayer, DamageInfo damageInfo) {
        return false;
    }
}

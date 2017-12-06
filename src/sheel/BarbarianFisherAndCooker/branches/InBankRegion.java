package src.sheel.BarbarianFisherAndCooker.branches;

import src.sheel.BarbarianFisherAndCooker.Constants;
import src.sheel.BarbarianFisherAndCooker.leaves.WalkToBank;
import src.sheel.BarbarianFisherAndCooker.TreeBot.BranchTask;
import src.sheel.BarbarianFisherAndCooker.TreeBot.TreeTask;
import org.powerbot.script.rt6.ClientContext;

public class InBankRegion extends BranchTask
{
    private WalkToBank walkToBankLeaf = new WalkToBank(ctx);
    private IsBankOpen isBankOpenBranch = new IsBankOpen(ctx);

    public InBankRegion(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean validate() {
        return ctx.players.local().tile().distanceTo(Constants.BANK_TILE) < 5;
    }

    @Override
    public TreeTask successTask() {
        return isBankOpenBranch;
    }

    @Override
    public TreeTask failureTask() {
        return walkToBankLeaf;
    }
}

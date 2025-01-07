package dtjadens;

import com.ferreusveritas.dynamictrees.api.TreeHelper;
import com.ferreusveritas.dynamictrees.block.branch.BranchBlock;
import com.ferreusveritas.dynamictrees.systems.BranchConnectables;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.state.BlockState;
import net.jadenxgamer.netherexp.registry.block.JNEBlocks;

public class DynamicTreesJadensRegistries {

    public static void setup()
    {
        BranchConnectables.makeBlockConnectable(JNEBlocks.SHROOMNIGHT.get(), (state, level, pos, side) -> {
            if (side == Direction.DOWN) {
                BlockState branchState = level.getBlockState(pos.relative(Direction.UP));
                BranchBlock branch = TreeHelper.getBranch(branchState);
                if (branch != null) {
                    return Mth.clamp(branch.getRadius(branchState) - 1, 1, 8);
                } else {
                    return 8;
                }
            }
            return 0;
        });
    }
}

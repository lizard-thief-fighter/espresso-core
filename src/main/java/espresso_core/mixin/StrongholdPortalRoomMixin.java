package espresso_core.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.structures.StrongholdPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(StrongholdPieces.PortalRoom.class)
public abstract class StrongholdPortalRoomMixin {
    @Inject(method = "postProcess", at = @At("HEAD"), cancellable = true)
    private void espresso_core$skipPortalRoom(WorldGenLevel level, StructureManager structureManager, ChunkGenerator generator,
                                              RandomSource random, BoundingBox box, ChunkPos chunkPos, BlockPos pivot, CallbackInfo ci) {
        // piece stays in the layout or strongholds regen, just dont place it
        ci.cancel();
    }
}

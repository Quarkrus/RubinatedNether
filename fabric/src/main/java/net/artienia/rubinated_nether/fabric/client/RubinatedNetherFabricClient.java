package net.artienia.rubinated_nether.fabric.client;

import dev.architectury.platform.Platform;
import net.artienia.rubinated_nether.block.ModBlocks;
import net.artienia.rubinated_nether.client.RubinatedNetherClient;
import net.artienia.rubinated_nether.fabric.client.trinkets.TrinketsRenderers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public final class RubinatedNetherFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        RubinatedNetherClient.clientSetup();

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MOLTEN_RUBY_GLASS.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MOLTEN_RUBY_GLASS_PANE.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUBY_GLASS.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUBY_GLASS_PANE.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUBY_LASER.get(), RenderType.cutout());

        if(Platform.isModLoaded("trinkets")) TrinketsRenderers.register();

    }
}

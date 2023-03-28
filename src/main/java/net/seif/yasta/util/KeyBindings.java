package net.seif.yasta.util;


import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {
    public static final String Key_Category_Attributes = "key.category.yasta";
    public static final String Key_Show_Attributes = "key.yasta.attributes";

    public static final KeyMapping Show_Attributes = new KeyMapping(Key_Show_Attributes,
            KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_K, Key_Category_Attributes);


}
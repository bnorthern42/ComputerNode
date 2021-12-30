package net.polarbear.api.Commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;

public class RegisterAll {
    public static void RegisterCommands(CommandDispatcher<CommandSourceStack> dispatcher){
        Console.register();
    }
}

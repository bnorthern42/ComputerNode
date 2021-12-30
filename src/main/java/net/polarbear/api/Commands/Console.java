package net.polarbear.api.Commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import io.apigee.trireme.core.*;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutionException;

public class Console{
    private static final Logger LOGGER = LogManager.getLogger();

    public static ArgumentBuilder<CommandSourceStack, ?> register(){
//  dispatcher.register(Commands.literal("node")
//    .executes(context -> NodeCommand(context.getSource(), context.getSource().getPlayerOrException(), ""))
        LOGGER.info("node command about to register");
      return  Commands.literal("node")
                        .requires(ctx -> ctx.hasPermission(2))
                .then(Commands.argument("node", StringArgumentType.greedyString())
                                .executes(context -> NodeCommand(context.getSource(),
                                                                 context.getSource().getPlayerOrException(),
                                                                 StringArgumentType.getString(context,
                                                                                        "node"))));

    }

    private static int NodeCommand(CommandSourceStack commandSourceStack, ServerPlayer player, String Command) {
        LOGGER.info("Hellow from Node Command Method :D");

        if(Command.length() > 1024 ){
            player.displayClientMessage(new TextComponent("Command is too long!, Limit is 1024 Chars"), false);
        }
        NodeEnvironment environment = new NodeEnvironment();

        try {
            NodeScript Script = environment.createScript(Command, new String(Command),null);

            ScriptFuture future = Script.execute();
            ScriptStatus status = future.get();
            if(status.isOk()){
                String output = "Command:" + status.toString();
                player.displayClientMessage(new TextComponent(output),false);
            }
            commandSourceStack.sendSuccess(new TranslatableComponent("NodeJS.Executed.Successfully"),true);
            return 1;

        } catch (NodeException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return 0;

    }
}

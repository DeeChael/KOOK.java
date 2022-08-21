package net.deechael.kook.command;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.deechael.kook.api.Message;
import net.deechael.kook.api.User;
import net.deechael.kook.command.brigadier.ChatArgumentType;
import net.deechael.kook.content.StringContent;

public interface SimpleCommandExecutor extends CommandExecutor {

    @Override
    default LiteralCommandNode<Message> brigadier(String name) {
        return LiteralArgumentBuilder.<Message>literal(name)
                .executes(context -> {
                    Message message = context.getSource();
                    this.execute(message.getAuthor(), message, new String[0]);
                    return 1;
                }).then(RequiredArgumentBuilder.<Message, StringContent>argument("args", ChatArgumentType.chat())
                        .executes(context -> {
                            Message message = context.getSource();
                            String content = ChatArgumentType.getChat(context, "args");
                            while (content.startsWith(" ")) {
                                content = content.substring(0, content.length() - 1);
                            }
                            while (content.endsWith(" ")) {
                                content = content.substring(0, content.length() - 1);
                            }
                            String[] args;
                            if (content.length() > 0) {
                                args = content.split(" ");
                            } else {
                                args = new String[0];
                            }
                            this.execute(message.getAuthor(), message, args);
                            return 1;
                        }))
                .build();
    }

    void execute(User sender, Message message, String[] args);

}

package net.deechael.kook.command;

import com.mojang.brigadier.tree.LiteralCommandNode;
import net.deechael.kook.api.Message;

public interface CommandExecutor {

    LiteralCommandNode<Message> brigadier(String name);

}

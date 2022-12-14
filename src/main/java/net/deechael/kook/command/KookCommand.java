package net.deechael.kook.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public final class KookCommand {

    private final String name;

    private final List<String> aliases = new ArrayList<>();
    private final List<String> prefixes = new ArrayList<>();

    private CommandExecutor executor;

    private String regex = null;

    private boolean mergeRest = false;

    public KookCommand(String name) {
        this.name = name;
        this.prefixes.add("/");
    }

    public List<String> getAliases() {
        return aliases;
    }

    public List<String> getPrefixes() {
        return prefixes;
    }

    public KookCommand setAliases(String... aliases) {
        this.aliases.clear();
        this.aliases.addAll(Arrays.asList(aliases));
        return this;
    }

    public KookCommand setAliases(Collection<String> aliases) {
        this.aliases.clear();
        this.aliases.addAll(aliases);
        return this;
    }

    public KookCommand setPrefixes(String... prefixes) {
        this.prefixes.clear();
        this.prefixes.addAll(Arrays.asList(prefixes));
        return this;
    }

    public KookCommand setPrefixes(Collection<String> prefixes) {
        this.prefixes.clear();
        this.prefixes.addAll(prefixes);
        return this;
    }

    public KookCommand setRegex(String regex) {
        this.regex = regex;
        return this;
    }

    public KookCommand setExecutor(CommandExecutor executor) {
        this.executor = executor;
        return this;
    }

}

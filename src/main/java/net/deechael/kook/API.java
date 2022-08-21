package net.deechael.kook;

import net.deechael.kook.annotation.NonParameters;
import net.deechael.kook.annotation.OptionalParameters;
import net.deechael.kook.annotation.Parameter;
import net.deechael.kook.annotation.RequiredParameters;
import net.deechael.kook.network.Route;

public final class API {

    public static final String BASE_URL = "https://www.kookapp.cn/api/v3/";

    private static final String POST = "POST";
    private static final String GET = "GET";

    private API() {
    }

    public static class V3 {

        public static class Guild {

            @OptionalParameters({
                    @Parameter(name = "page", location = "query", type = int.class),
                    @Parameter(name = "page_size", location = "query", type = int.class),
                    @Parameter(name = "sort", location = "query", type = String.class)
            })
            public static Route list() {
                return new Route(GET, "guild/list");
            }

            @RequiredParameters({
                    @Parameter(name = "guild_id", type = String.class)
            })
            public static Route view() {
                return new Route(GET, "guild/view");
            }

            @RequiredParameters({
                    @Parameter(name = "guild_id", location = "query", type = String.class)
            })
            @OptionalParameters({
                    @Parameter(name = "sort", location = "query", type = String.class),
                    @Parameter(name = "channel_id", location = "query", type = String.class),
                    @Parameter(name = "search", location = "query", type = String.class),
                    @Parameter(name = "role_id", location = "query", type = int.class),
                    @Parameter(name = "mobile_verified", location = "query", type = int.class),
                    @Parameter(name = "active_time", location = "query", type = int.class),
                    @Parameter(name = "joined_at", location = "query", type = int.class),
                    @Parameter(name = "page", location = "query", type = int.class),
                    @Parameter(name = "page_size", location = "query", type = int.class),
                    @Parameter(name = "filter_user_id", location = "query", type = String.class)
            })
            public static Route userList() {
                return new Route(GET, "guild/user-list");
            }

            public static Route nickname() {
                return new Route(POST, "guild/nickname");
            }

            public static Route leave() {
                return new Route(POST, "guild/leave");
            }

            public static Route kickout() {
                return new Route(POST, "guild/kickout");
            }

        }

        public static class GuildMute {

            public static Route list() {
                return new Route(GET, "guild-mute/list");
            }

            public static Route create() {
                return new Route(POST, "guild-mute/create");
            }

            public static Route delete() {
                return new Route(POST, "guild-mute/delete");
            }

        }

        public static class Channel {

            public static Route list() {
                return new Route(GET, "channel/list");
            }

            public static Route view() {
                return new Route(GET, "channel/view");
            }

            public static Route update() {
                return new Route(POST, "channel/update");
            }

            public static Route create() {
                return new Route(POST, "channel/create");
            }

            public static Route delete() {
                return new Route(POST, "channel/delete");
            }

            public static Route userList() {
                return new Route(GET, "channel/user-list");
            }

            public static Route moveUser() {
                return new Route(POST, "channel/move-user");
            }

        }

        public static class ChannelRole {

            public static Route index() {
                return new Route(GET, "channel-role/index");
            }

            public static Route create() {
                return new Route(POST, "channel-role/create");
            }

            public static Route update() {
                return new Route(POST, "channel-role/update");
            }

            public static Route delete() {
                return new Route(POST, "channel-role/delete");
            }

        }

        public static class Message {

            public static Route list() {
                return new Route(GET, "message/list");
            }

            public static Route create() {
                return new Route(POST, "message/create");
            }

            public static Route update() {
                return new Route(POST, "message/update");
            }

            public static Route delete() {
                return new Route(POST, "message/delete");
            }

            public static Route reactionList() {
                return new Route(GET, "message/reaction-list");
            }

            public static Route addReaction() {
                return new Route(POST, "message/add-reaction");
            }

            public static Route deleteReaction() {
                return new Route(POST, "message/delete-reaction");
            }

        }

        public static class ChannelUser {

            public static Route getJoinedChannel() {
                return new Route(GET, "channel-user/get-joined-channel");
            }

        }

        public static class UserChat {

            public static Route list() {
                return new Route(GET, "user-chat/list");
            }

            public static Route view() {
                return new Route(GET, "user-chat/view");
            }

            public static Route create() {
                return new Route(POST, "user-chat/create");
            }

            public static Route delete() {
                return new Route(POST, "user-chat/delete");
            }
        }

        public static class DirectMessage {

            public static Route list() {
                return new Route(GET, "direct-message/list");
            }

            public static Route create() {
                return new Route(POST, "direct-message/create");
            }

            public static Route update() {
                return new Route(POST, "direct-message/update");
            }

            public static Route delete() {
                return new Route(POST, "direct-message/delete");
            }

            public static Route reactionList() {
                return new Route(GET, "direct-message/reaction-list");
            }

            public static Route addReaction() {
                return new Route(POST, "direct-message/add-reaction");
            }

            public static Route deleteReaction() {
                return new Route(POST, "direct-message/delete-reaction");
            }

        }

        public static class GuildRole {

            public static Route list() {
                return new Route(GET, "guild-role/list");
            }

            public static Route create() {
                return new Route(POST, "guild-role/create");
            }

            public static Route update() {
                return new Route(POST, "guild-role/update");
            }

            public static Route delete() {
                return new Route(POST, "guild-role/delete");
            }

            public static Route grant() {
                return new Route(POST, "guild-role/grant");
            }

            public static Route revoke() {
                return new Route(POST, "guild-role/revoke");
            }
        }

        public static class Intimacy {

            public static Route index() {
                return new Route(GET, "intimacy/index");
            }

            public static Route update() {
                return new Route(POST, "intimacy/update");
            }

        }

        public static class GuildEmoji {

            public static Route list() {
                return new Route(GET, "guild-emoji/list");
            }

            public static Route create() {
                return new Route(POST, "guild-emoji/create");
            }

            public static Route update() {
                return new Route(POST, "guild-emoji/update");
            }

            public static Route delete() {
                return new Route(POST, "guild-emoji/delete");
            }
        }

        public static class Invite {

            public static Route list() {
                return new Route(GET, "invite/list");
            }

            public static Route create() {
                return new Route(POST, "invite/create");
            }

            public static Route delete() {
                return new Route(POST, "invite/delete");
            }

        }

        public static class Gateway {

            public static Route index() {
                return new Route(GET, "gateway/index");
            }

        }

        public static class Asset {

            public static Route create() {
                return new Route(POST, "asset/create");
            }

        }

        public static class User {

            public static Route me() {
                return new Route(GET, "user/me");
            }

            public static Route view() {
                return new Route(GET, "user/view");
            }

            public static Route offline() {
                return new Route(POST, "user/offline");
            }

        }

        public static class Game {

            @NonParameters
            public static Route list() {
                return new Route("GET", "game");
            }

            @RequiredParameters(@Parameter(name = "name", type = String.class))
            @OptionalParameters(@Parameter(name = "icon", type = String.class))
            public static Route create() {
                return new Route(POST, "game/create");
            }

            @RequiredParameters(@Parameter(name = "id", type = int.class))
            @OptionalParameters({
                    @Parameter(name = "name", type = String.class),
                    @Parameter(name = "icon", type = String.class)
            })
            public static Route update() {
                return new Route(POST, "game/update");
            }

            @RequiredParameters(@Parameter(name = "id", type = int.class))
            public static Route delete() {
                return new Route(POST, "game/delete");
            }

            @RequiredParameters({
                    @Parameter(name = "id", type = int.class),
                    @Parameter(name = "data_type", type = int.class, mustBe = "int:1")
            })
            public static Route activity() {
                return new Route(POST, "game/activity");
            }

            @RequiredParameters(@Parameter(name = "data_type", type = int.class, mustBe = "int:1"))
            public static Route deleteActivity() {
                return new Route(POST, "game/delete-activity");
            }

        }

    }

}
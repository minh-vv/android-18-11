package vn.edu.hust.bai3.data

import vn.edu.hust.bai3.model.AppItem

object AppDataProvider {

    fun getSponsoredApps(): List<AppItem> {
        return listOf(
            AppItem(
                name = "Mech Assemble: Zombie Swarm",
                imageRes = android.R.drawable.sym_def_app_icon,
                genre = "Action • Role Playing • Roguelike • Zombie",
                rating = "4.8",
                size = "624 MB"
            ),
            AppItem(
                name = "MU: Hồng Hoá Đảo",
                imageRes = android.R.drawable.sym_action_chat,
                genre = "Role Playing",
                rating = "4.8",
                size = "339 MB"
            ),
            AppItem(
                name = "War Inc: Rising",
                imageRes = android.R.drawable.ic_menu_camera,
                genre = "Strategy • Tower defense",
                rating = "4.9",
                size = "231 MB"
            ),
            AppItem(
                name = "Clash of Clans",
                imageRes = android.R.drawable.ic_menu_mapmode,
                genre = "Strategy • Multiplayer",
                rating = "4.6",
                size = "256 MB"
            )
        )
    }

    /**
     * Get sample data for recommended apps section
     */
    fun getRecommendedApps(): List<AppItem> {
        return listOf(
            AppItem(
                name = "Suno - AI Music & Songs",
                imageRes = android.R.drawable.star_big_on,
                genre = "Music & Audio"
            ),
            AppItem(
                name = "Claude by Anthropic",
                imageRes = android.R.drawable.star_on,
                genre = "Productivity"
            ),
            AppItem(
                name = "DramaBox - Short Drama",
                imageRes = android.R.drawable.btn_star_big_on,
                genre = "Entertainment"
            ),
            AppItem(
                name = "Pika AI Video",
                imageRes = android.R.drawable.btn_star,
                genre = "Video Players"
            ),
            AppItem(
                name = "Spotify Music",
                imageRes = android.R.drawable.ic_media_play,
                genre = "Music & Audio"
            ),
            AppItem(
                name = "TikTok",
                imageRes = android.R.drawable.ic_menu_slideshow,
                genre = "Social Media"
            )
        )
    }
}


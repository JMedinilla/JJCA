package ncatz.jvmed.jjca.data

data class Volume(
        var part: Int,
        var number: Int,
        val download: Boolean,
        var title: String,
        var description: String,
        var base64: String
)
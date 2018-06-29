package ncatz.jvmed.jjca.data

data class Volume(
        var part: Int,
        var number: Int,
        var title: String,
        var description: String,
        var base64: String
)
package jp.kosuke.kinoshita.coroutinesapplication

data class Weather(
    val publicTime: String,
    val title: String,
    val description: Description,
    val link: String,
    val forecasts: List<Forecast>,
    val location: jp.kosuke.kinoshita.coroutinesapplication.Location,
    val pinpointLocations: List<PinpointLocation>,
    val copyright: Copyright
)

data class PinpointLocation(
    val link: String,
    val name: String
)

data class Copyright(
    val provider: List<jp.kosuke.kinoshita.coroutinesapplication.Provider>,
    val link: String,
    val title: String,
    val image: Image
)

data class Image(
    val width: Int,
    val link: String?,
    val url: String,
    val title: String,
    val height: Int
)

data class Provider(
    val link: String,
    val name: String
)

data class Forecast(
    val dateLabel: String,
    val telop: String,
    val date: String,
    val temperature: Temperature,
    val image: Image
)

data class Temperature(
    val min: Any?,
    val max: Any?
)

data class Location(
    val city: String,
    val area: String,
    val prefecture: String
)

data class Description(
    val text: String,
    val publicTime: String
)

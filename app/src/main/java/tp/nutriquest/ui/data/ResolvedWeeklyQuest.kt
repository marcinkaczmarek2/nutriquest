package tp.nutriquest.ui.data

data class ResolvedWeeklyQuest(
    val title: String,
    val information: String,
    val notAllowedFor: List<String>,
    val progress: ResolvedProgress,
    val isChecked: Boolean
)



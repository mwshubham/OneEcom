# Moshi Description

* We will initialize each variable with null and access it via custom getter handling the nullability and other issues which might cause application to crash.

* all the variable be prefixed with '_' and getter and setter to be made to avoid NPEs KNPEs

## SAMPLE

------
test.json
------

{
  "hidden_card": {
    "suit": "SPADES"
  },
  "visible_cards": [
    {
      "rank": "4",
      "suit": "CLUBS"
    },
    {
      "rank": "A",
      "suit": "HEARTS"
    }
  ]
}




val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

val jsonAdapter = moshi.adapter(BlackjackHand::class.java)
val blackjackHand = jsonAdapter.fromJson(CoreFileUtils.getStringFromAssets("test.json"))!!
Timber.d(blackjackHand.toString())
Timber.d(blackjackHand.getHiddenCard().toString())
Timber.d(blackjackHand.getVisibleCards().toString())
Timber.d(blackjackHand.getHiddenCard().getRank().toString())
Timber.d(blackjackHand.getHiddenCard().getSuit().toString())

data class BlackjackHand(
    @Json(name = "hidden_card")
    val _hiddenCard: Card?,
    @Json(name = "visible_cards")
    val _visibleCards: List<Card>?
) {
    fun getHiddenCard(): Card {
        return _hiddenCard ?: Card()
    }

    fun getVisibleCards(): List<Card> {
        return _visibleCards ?: ArrayList(0)
    }
}

data class Card(
    @Json(name = "rank")
    val _rank: Char?,
    @Json(name = "suit")
    val _suit: Suit?
) {
    constructor() : this('-', Suit.CLUBS)

    fun getRank(): Char {
        return _rank ?: '-'
    }

    fun getSuit(): Suit {
        return _suit ?: Suit.CLUBS
    }

}

enum class Suit {
    CLUBS, DIAMONDS, HEARTS, SPADES;
}

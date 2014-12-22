Uses linked list and modified version of linked list called CircularlyLinkedLists.

To run this game simply run the Solitaire.java and use these commands to interact:

**DrawCard**: Open the next card on the card deck.

**DeckTo x**: Move one card from the deck to the xth list. For example the command
DeckTo 3 moves the card that is currently open in the card deck to the third list.

**Link c x**: Suppose c is a revealed card in a card list, and 1 ≤x≤ 7. This command
moves all cards below and including c in the same list to the xth list. For example the
command Link Spade9 6 moves all card below and including Spade6 to the 6th card
list; see the screenshot below.

**Send c**: Suppose c is a tail card of a card list. This command moves the card c to
the stack that corresponds to its suit.

**Restart**: Restart the game.

**Quit**: Stop the game.

• If the game is won, the CUI should print out a line congratulating the player

**Send Command does not work**

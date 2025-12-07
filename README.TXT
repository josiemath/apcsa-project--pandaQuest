# PandaQuest (final-apcsa-project-)

One-line overview:
A Greenfoot-based puzzle/adventure tile-revealing game where the player controls a panda navigating a tile grid, revealing safe tiles, avoiding bamboo, and collecting stars; includes menu, shop, and mini-game screens.

How to run:
- Open the project in Greenfoot and run StartScreen.
- Use arrow keys to move, SPACE to reveal tiles, 'a' to place a flag, 'b' to remove a flag.

Main components:
- PandaWorld.java — main game world and game state manager.
- Panda.java — player actor that moves, reveals tiles, and flags tiles.
- Levels.java — global level and configuration state.
- TileMarker.java — displays adjacent-bamboo counts for revealed tiles.
- Bamboo.java / Star.java — harmful and beneficial tile actors.
- ShopScreen.java / ShopButton.java — UI for selecting panda skins.
- MiniGameScreen.java / Chest.java / MiniGameSummary.java — post-level mini-game flow.
- StartScreen.java / StartButton.java — main menu entry point.

Purpose of repository:
Provide the full source for the PandaQuest Greenfoot project with UI screens, multiple levels, player skins, and a chest mini-game used during progression.

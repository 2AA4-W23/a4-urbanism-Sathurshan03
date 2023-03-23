package ca.mcmaster.cas.se2aa4.a3.island.TilesTypes;
import ca.mcmaster.cas.se2aa4.a3.island.Terrains.LandComposition;

import java.awt.Color;


public enum TileTypes {
    UNDETERMINEDLAND(new Color(153,76,0,254), TileElement.UNDETERMINED,LandComposition.NOTSOIL),
    AQUIFERS(new Color(255,0,0,254), TileElement.WATER,LandComposition.NOTSOIL),
    BEACH(new Color(255,250,201,254),TileElement.LAND,LandComposition.SOIL),
    Ocean(new Color(0,65,114,254), TileElement.WATER,LandComposition.NOTSOIL),
    LAGOON(new Color(25,132,226, 254), TileElement.WATER,LandComposition.NOTSOIL),
    LAKE(new Color(15,94,196, 254), TileElement.WATER, LandComposition.NOTSOIL),
    GRASSLAND(new Color(0,153,0,254), TileElement.LAND,LandComposition.SOIL),
    ENDORHEICLAKE(new Color(15,94,196,254), TileElement.WATER,LandComposition.NOTSOIL),
    ICE(new Color(192,200,255,254), TileElement.LAND, LandComposition.NOTSOIL),
    SNOW(new Color(255,250,251,254), TileElement.LAND,LandComposition.NOTSOIL),
    TAIGA(new Color(0,110,0,254), TileElement.LAND,LandComposition.SOIL),
    TUNDRA(new Color(140,151,133,254), TileElement.LAND,LandComposition.SOIL),
    SAND(new Color(255,250,201,254), TileElement.LAND,LandComposition.SOIL),
    DIRT(new Color(155,118,83,254), TileElement.LAND,LandComposition.SOIL),
    SAVANNA(new Color(209,189,146,254), TileElement.LAND,LandComposition.NOTSOIL),
    CLAY(new Color(182,106,80,254), TileElement.LAND,LandComposition.NOTSOIL),
    ROCK(new Color(227,229,226,254), TileElement.LAND,LandComposition.NOTSOIL),
    FOREST(new Color(1,68,33,254), TileElement.LAND,LandComposition.SOIL);






    public final Color tileColor;
    public final TileElement tileElement;
    public final LandComposition composition;
    private TileTypes(Color color, TileElement element, LandComposition comp){
        tileColor = color;
        tileElement = element;
        composition=comp;
    }
    public Color getColor(){
        return tileColor;
    }
    public TileElement getElememt(){
        return tileElement;
    }

    public LandComposition getComposition(){
        return composition;
    }

}

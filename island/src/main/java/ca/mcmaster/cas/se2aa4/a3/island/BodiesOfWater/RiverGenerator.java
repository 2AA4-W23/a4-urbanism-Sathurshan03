package ca.mcmaster.cas.se2aa4.a3.island.BodiesOfWater;

import java.util.ArrayList;
import java.util.List;

import ca.mcmaster.cas.se2aa4.a3.island.IslandCommandLineReader;
import ca.mcmaster.cas.se2aa4.a3.island.BuildingBlocks.Tile;
import ca.mcmaster.cas.se2aa4.a3.island.BuildingBlocks.TileSegment;
import ca.mcmaster.cas.se2aa4.a3.island.BuildingBlocks.TileVertex;

public class RiverGenerator {
    int maxRivers;
    List<Tile> tiles;
    List<River> rivers;
    
    public RiverGenerator(List<Tile> tiles, int maxRivers){
        this.tiles = tiles;
        this.maxRivers = maxRivers;
        this.rivers = new ArrayList<>();
    }

    public void createRivers(){
        Boolean riverStartFound;
        TileVertex riverStart = null;
        Tile currentTile = null;
        River river;

        for (int i = 0; i < maxRivers; i++){
            riverStartFound = false;

            //Find a valid starting point for the river
            while (!riverStartFound)
            {
                currentTile = tiles.get(IslandCommandLineReader.randomGenerator.getNextInteger(0,tiles.size()));
                if (currentTile.isTileLand()){
                    int pos = IslandCommandLineReader.randomGenerator.getNextInteger(0,currentTile.tileVerticesListSize());
                    TileVertex consideringVertex = currentTile.getTileVertex(pos);
                    if (consideringVertex.isVertexLand()){
                        riverStart = consideringVertex;
                        riverStartFound = true;
                    }
                }
            }

            river = new River(riverStart);
            extendRiver(riverStart, currentTile, river);
            river.setRiverAttributes();
            rivers.add(river);
        }
    }

    public void extendRiver(TileVertex riverStart, Tile currentTile, River river){
        //extend the river
        TileVertex previousRiverVertex  = riverStart;
        TileVertex possibleRiverVertex;
        TileSegment possibleRiverSegment;
        Tile possibleAdjacentRiverTile;
        Boolean waterFlowFound;
        double minElevation = previousRiverVertex.getElevation();

        while(previousRiverVertex.isVertexLand()){
            possibleRiverVertex = null;
            possibleRiverSegment = null;
            possibleAdjacentRiverTile = null;
            waterFlowFound = false;

            //Find all the possible segments from neighbouring polygons and check if their adjacent vertex is lower than previousRiverVertex
            for(Tile tile: currentTile.getNeighbouringTile()){
                for (TileSegment segment: tile.getTileSegments()){
                    if (segment.containsTileVertex(previousRiverVertex)){
                        TileVertex adjacentVertex = segment.getAdjacentVertex(previousRiverVertex);
                        if (adjacentVertex.getElevation() < minElevation && river.canAddVertexToRiver(adjacentVertex)){
                            minElevation = adjacentVertex.getElevation();
                            possibleRiverVertex = adjacentVertex;
                            possibleRiverSegment = segment;
                            possibleAdjacentRiverTile = tile;
                            waterFlowFound = true;
                        }
                    }
                }
            }

            //Add the next sequence of segment and vertex to the river
            if (waterFlowFound){
                river.addRiverSegment(possibleRiverSegment);
                river.addRiverVertex(possibleRiverVertex);
                previousRiverVertex = possibleRiverVertex;
                currentTile = possibleAdjacentRiverTile;
            }
            else{
                //if no water flow is found, then the river ends here
                break;
            }
        }
    }
    
}

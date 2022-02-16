package org.godfather.bsolo.manager.map;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.HashSet;
import java.util.Set;

public class BlockManager {

    private final Set<Location> blockMap = new HashSet<>();

    public Set<Location> getPlacedBlocks(){
        return blockMap;
    }

    public boolean isBlockBreakable(Block block){
        return blockMap.contains(block.getLocation());
    }

    public void addBlock(Block block){
        blockMap.add(block.getLocation());
    }

    public void removeBlock(Block block){
        block.setType(Material.AIR);
        blockMap.remove(block.getLocation());
    }

    public void reset(){
        blockMap.clear();
    }
}

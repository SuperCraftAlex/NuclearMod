package net.supercraftalex.nuclearmod.block.machine.rbmk;

public enum RBMKBlockType {
    //TYPE              WHAT                                              ARG1        ARG2              ARG3
    TRANSMIT,       //Transmit neutrons and heat
    MODERATE,       //Slows down neutrons                              slowdownspeed
    REDUCE,         //Reduces neutrons             how muc hpercent of  neutrons
    REDUCEHEAT,     //Reduces heat                 how much percent of   heat
    BLOCKHEAT,      //Blocks heat
    STOP,           //Stop neutrons
    FUEL,           //Fuel                                         neutrons/fission  heat/fission    heat to melt
    REFLECT,        //Reflect neutrons
    STOPALL         //Stops neutrons and heat

}
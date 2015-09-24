package org.cf.smalivm.opcode;

import gnu.trove.map.TIntObjectMap;

import org.cf.smalivm.VirtualMachine;
import org.cf.util.Utils;
import org.jf.dexlib2.builder.BuilderInstruction;
import org.jf.dexlib2.iface.instruction.formats.Instruction12x;

public class UnaryMathOpFactory implements OpFactory {

    @Override
    public Op create(BuilderInstruction instruction, TIntObjectMap<BuilderInstruction> addressToInstruction,
                    VirtualMachine vm) {
        BuilderInstruction child = Utils.getNextInstruction(instruction, addressToInstruction);
        Instruction12x instr = (Instruction12x) instruction;
        int destRegister = instr.getRegisterA();
        int srcRegister = instr.getRegisterB();

        return new UnaryMathOp(instruction, child, destRegister, srcRegister);
    }

}

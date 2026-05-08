package com.narxoz.rpg.artifact;

public class EnchantmentScanner implements ArtifactVisitor{

    private int magicalCount = 0;

    @Override
    public void visit(Weapon weapon) {
        boolean hasEnchant = weapon.getAttackBonus() >= 5;
        if (hasEnchant) magicalCount++;
        System.out.println("  [EnchantScanner] Weapon  '" + weapon.getName()
                + "' aura: " + (hasEnchant ? "RADIANT (+" + weapon.getAttackBonus() + " atk)" : "mundane edge"));
    }

    @Override
    public void visit(Potion potion) {
        magicalCount++;
        System.out.println("  [EnchantScanner] Potion  '" + potion.getName()
                + "' brew: alchemical (heals " + potion.getHealing() + ")");
    }

    @Override
    public void visit(Scroll scroll) {
        magicalCount++;
        System.out.println("  [EnchantScanner] Scroll  '" + scroll.getName()
                + "' bound spell: << " + scroll.getSpellName() + " >>");
    }

    @Override
    public void visit(Ring ring) {
        magicalCount++;
        System.out.println("  [EnchantScanner] Ring    '" + ring.getName()
                + "' resonance: arcane band (+" + ring.getMagicBonus() + " magic)");
    }

    @Override
    public void visit(Armor armor) {
        boolean hasEnchant = armor.getDefenseBonus() >= 8;
        if (hasEnchant) magicalCount++;
        System.out.println("  [EnchantScanner] Armor   '" + armor.getName()
                + "' weave: " + (hasEnchant ? "RUNE-WARDED (+" + armor.getDefenseBonus() + " def)" : "plain steel"));
    }

    public int getMagicalCount() {
        return magicalCount;
    }
}

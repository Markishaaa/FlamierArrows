package markisha.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;

public class DetectArrow implements Listener {

	private ItemStack bow;

	@EventHandler
	public void setBlockOnFire(ProjectileHitEvent e) {
		Projectile p = e.getEntity();

		if (p instanceof Arrow && bow != null) {
			Block b = e.getHitBlock();

			if (b != null) {
				BlockFace face = e.getHitBlockFace();

				Block related = b.getRelative(face);

				if (!related.getType().isSolid())
					related.setType(Material.FIRE);
			}
		}
	}

	@EventHandler
	public void findBow(PlayerItemDamageEvent e) {
		ItemStack i = e.getItem();

		if (i.getType().equals(Material.BOW) && i.containsEnchantment(Enchantment.ARROW_FIRE)) {
			bow = i;
		} else {
			bow = null;
		}
	}

}

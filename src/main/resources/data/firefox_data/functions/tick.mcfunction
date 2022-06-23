# 数据包函数：用于查看人是否可以传送，实时不间断运行判据

scoreboard players set @a player_reach_range 13

# 确定玩家维度位置
# 主世界
execute as @a[scores={re8_dimension_portal_activation_check=1..},predicate=firefox_data:dimensions/overworld] at @s rotated as @s anchored eyes run function firefox_data:activate/locate_block/re8_dimension
# 火世界
execute as @a[scores={re8_dimension_portal_activation_check=1..},predicate=firefox_data:dimensions/fire_world] at @s rotated as @s anchored eyes run function firefox_data:activate/locate_block/re8_dimension

# 重置使用对应物品的分数
scoreboard players set @a re8_dimension_portal_activation_check 0

# 实时运行以下函数：
function firefox_data:run/main/re8_dimension

# 条件重置
execute as @e[predicate=firefox_data:travellers/all_mobs] unless score @s re8portals_cooldown = @s re8portals_cooldown run scoreboard players set @s re8portals_cooldown 0
execute as @e[predicate=firefox_data:travellers/all_mobs,scores={re8portals_cooldown=1..}] unless entity @e[type=armor_stand,tag=re8portals_portal_stand,distance=...5] run scoreboard players remove @s re8portals_cooldown 1

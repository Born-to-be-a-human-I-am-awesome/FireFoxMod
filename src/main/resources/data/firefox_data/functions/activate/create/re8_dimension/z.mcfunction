# 填充传送方块
fill ~ ~ ~ ~ ~2 ~1 minecraft:moving_piston

# Summon armor stands for portal blocks
summon armor_stand ~.506 ~ ~0.5 {Rotation:[90F,0F],NoGravity:1b,Silent:1b,Invulnerable:1b,ShowArms:1b,Marker:1b,Invisible:1b,Tags:["wabportals_aether_portal_stand","wabportals_portal_stand"],ArmorItems:[{},{},{},{id:"re8joymod:aterrimus_glass_pane",Count:1b,tag:{CustomModelData:286000}}]}
summon armor_stand ~.506 ~ ~1.5 {Rotation:[90F,0F],NoGravity:1b,Silent:1b,Invulnerable:1b,ShowArms:1b,Marker:1b,Invisible:1b,Tags:["wabportals_aether_portal_stand","wabportals_portal_stand"],ArmorItems:[{},{},{},{id:"re8joymod:aterrimus_glass_pane",Count:1b,tag:{CustomModelData:286000}}]}
summon armor_stand ~.506 ~1 ~.5 {Rotation:[90F,0F],NoGravity:1b,Silent:1b,Invulnerable:1b,ShowArms:1b,Marker:1b,Invisible:1b,Tags:["wabportals_aether_portal_stand","wabportals_portal_stand"],ArmorItems:[{},{},{},{id:"re8joymod:aterrimus_glass_pane",Count:1b,tag:{CustomModelData:286000}}]}
summon armor_stand ~.506 ~1 ~1.5 {Rotation:[90F,0F],NoGravity:1b,Silent:1b,Invulnerable:1b,ShowArms:1b,Marker:1b,Invisible:1b,Tags:["wabportals_aether_portal_stand","wabportals_portal_stand"],ArmorItems:[{},{},{},{id:"re8joymod:aterrimus_glass_pane",Count:1b,tag:{CustomModelData:286000}}]}
summon armor_stand ~.506 ~2 ~.5 {Rotation:[90F,0F],NoGravity:1b,Silent:1b,Invulnerable:1b,ShowArms:1b,Marker:1b,Invisible:1b,Tags:["wabportals_aether_portal_stand","wabportals_portal_stand"],ArmorItems:[{},{},{},{id:"re8joymod:panic_rose",Count:1b,tag:{CustomModelData:286000}}]}
summon armor_stand ~.506 ~2 ~1.5 {Rotation:[90F,0F],NoGravity:1b,Silent:1b,Invulnerable:1b,ShowArms:1b,Marker:1b,Invisible:1b,Tags:["wabportals_aether_portal_stand","wabportals_portal_stand"],ArmorItems:[{},{},{},{id:"re8joymod:panic_rose",Count:1b,tag:{CustomModelData:286000}}]}

summon marker ~.506 ~ ~.5 {NoGravity:1b,Silent:1b,Invulnerable:1b,Tags:["re8portals_re8_dimension_marker","re8portals_re8_dimension_marker_z"]}


# Play a portal opening sound (OPTIONAL)
# 播放音效(可选)
playsound minecraft:block.end_portal.spawn master @a ~ ~ ~ 15 1

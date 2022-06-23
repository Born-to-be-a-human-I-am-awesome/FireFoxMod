# 查看玩家在哪个地点创建了传送门
execute if block ~ ~ ~ #firefox_data:activation/fire_world if block ~ ~-1 ~ #firefox_data:frame/fire_world run function firefox_data:activate/check_frame/re8_dimension/bottom
execute if block ~ ~ ~ #firefox_data:activation/fire_world if block ~ ~-2 ~ #firefox_data:frame/fire_world run function firefox_data:activate/check_frame/re8_dimension/mid
execute if block ~ ~ ~ #firefox_data:activation/fire_world if block ~ ~-3 ~ #firefox_data:frame/fire_world run function firefox_data:activate/check_frame/re8_dimension/top
scoreboard players remove @s player_reach_range 1
execute if score @s player_reach_range matches 1.. if block ~ ~ ~ #firefox_data:air positioned ^ ^ ^0.5 run function firefox_data:activate/locate_block/re8_dimension

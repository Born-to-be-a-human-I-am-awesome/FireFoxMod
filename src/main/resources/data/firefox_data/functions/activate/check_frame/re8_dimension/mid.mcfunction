# 查看我们传送门中部是否有对应的方块
# North
execute if block ~ ~-2 ~ #firefox_data:frame/re8_dimension if block ~ ~-2 ~1 #firefox_data:frame/re8_dimension if block ~ ~-1 ~-1 #firefox_data:frame/re8_dimension if block ~ ~-1 ~2 #firefox_data:frame/re8_dimension if block ~ ~ ~-1 #firefox_data:frame/re8_dimension if block ~ ~ ~2 #firefox_data:frame/re8_dimension if block ~ ~1 ~-1 #firefox_data:frame/re8_dimension if block ~ ~1 ~2 #firefox_data:frame/re8_dimension if block ~ ~2 ~ #firefox_data:frame/re8_dimension if block ~ ~2 ~1 #firefox_data:frame/re8_dimension if block ~ ~-1 ~ #firefox_data:air if block ~ ~-1 ~1 #firefox_data:air if block ~ ~ ~1 #firefox_data:air if block ~ ~1 ~ #firefox_data:air if block ~ ~1 ~1 #firefox_data:air positioned ~ ~-1 ~ align xyz run function firefox_data:activate/create/re8_dimension/z

# South
execute if block ~ ~-2 ~ #firefox_data:frame/re8_dimension if block ~ ~-2 ~-1 #firefox_data:frame/re8_dimension if block ~ ~-1 ~-2 #firefox_data:frame/re8_dimension if block ~ ~-1 ~1 #firefox_data:frame/re8_dimension if block ~ ~ ~-2 #firefox_data:frame/re8_dimension if block ~ ~ ~1 #firefox_data:frame/re8_dimension if block ~ ~1 ~-2 #firefox_data:frame/re8_dimension if block ~ ~1 ~1 #firefox_data:frame/re8_dimension if block ~ ~2 ~ #firefox_data:frame/re8_dimension if block ~ ~2 ~-1 #firefox_data:frame/re8_dimension if block ~ ~-1 ~ #firefox_data:air if block ~ ~-1 ~-1 #firefox_data:air if block ~ ~ ~-1 #firefox_data:air if block ~ ~1 ~ #firefox_data:air if block ~ ~1 ~-1 #firefox_data:air positioned ~ ~-1 ~-1 align xyz run function firefox_data:activate/create/re8_dimension/z

# East
execute if block ~ ~-2 ~ #firefox_data:frame/re8_dimension if block ~-1 ~-2 ~ #firefox_data:frame/re8_dimension if block ~1 ~-1 ~ #firefox_data:frame/re8_dimension if block ~-2 ~-1 ~ #firefox_data:frame/re8_dimension if block ~1 ~ ~ #firefox_data:frame/re8_dimension if block ~-2 ~ ~ #firefox_data:frame/re8_dimension if block ~1 ~1 ~ #firefox_data:frame/re8_dimension if block ~-2 ~1 ~ #firefox_data:frame/re8_dimension if block ~ ~2 ~ #firefox_data:frame/re8_dimension if block ~-1 ~2 ~ #firefox_data:frame/re8_dimension if block ~ ~-1 ~ #firefox_data:air if block ~-1 ~-1 ~ #firefox_data:air if block ~-1 ~ ~ #firefox_data:air if block ~ ~1 ~ #firefox_data:air if block ~-1 ~1 ~ #firefox_data:air positioned ~-1 ~-1 ~ align xyz run function firefox_data:activate/create/re8_dimension/x

# West
execute if block ~ ~-2 ~ #firefox_data:frame/re8_dimension if block ~1 ~-2 ~ #firefox_data:frame/re8_dimension if block ~2 ~-1 ~ #firefox_data:frame/re8_dimension if block ~-1 ~-1 ~ #firefox_data:frame/re8_dimension if block ~2 ~ ~ #firefox_data:frame/re8_dimension if block ~-1 ~ ~ #firefox_data:frame/re8_dimension if block ~2 ~1 ~ #firefox_data:frame/re8_dimension if block ~-1 ~1 ~ #firefox_data:frame/re8_dimension if block ~ ~2 ~ #firefox_data:frame/re8_dimension if block ~1 ~2 ~ #firefox_data:frame/re8_dimension if block ~ ~-1 ~ #firefox_data:air if block ~1 ~-1 ~ #firefox_data:air if block ~1 ~ ~ #firefox_data:air if block ~ ~1 ~ #firefox_data:air if block ~1 ~1 ~ #firefox_data:air positioned ~ ~-1 ~ align xyz run function firefox_data:activate/create/re8_dimension/x
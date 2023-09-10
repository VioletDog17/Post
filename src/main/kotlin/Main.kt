fun main(args: Array<String>) {
    val comments = Comment()
    val likes = Likes()
    val service = WallService()
    val post1 = DataPost(like = likes, comment = comments)
    val post2 = DataPost(like = likes, comment = comments)
    val post3 = DataPost(like = likes, comment = comments)
    service.add(post1)
    service.add(post2)
    service.add(post3)
    val post4 = post3.copy(text = "^-*-^")
    service.update(post4)
}


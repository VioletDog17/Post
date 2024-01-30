import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class WallServiceTest {

    @Test
    fun add() {
        val comments = Comment()
        val likes = Likes()
        var post = DataPost(like = likes, comment = comments, signer_id = null)
        val service = WallService()
        var commitPost = service.add(post)
        assertTrue(commitPost.id != post.id && commitPost.id != 0)
    }

    @Test
    fun updateSuccessful() {
        val comments = Comment()
        val likes = Likes()
        var post = DataPost(like = likes, comment = comments, signer_id = null)
        val service = WallService()
        service.add(post)
        var post2 = DataPost(like = likes, comment = comments, signer_id = null)
        service.add(post2)
        assertTrue(service.update(post2))

    }

    @Test
    fun updateUnSuccessful() {
        val comments = Comment()
        val likes = Likes()
        var post = DataPost(like = likes, comment = comments,signer_id = null)
        val service = WallService()
        service.add(post)
        var post2 = DataPost(like = likes, comment = comments, signer_id = null)
        service.add(post2)
        var post3 = DataPost(id = -2, like = likes, comment = comments, signer_id = null)
        assertFalse(service.update(post3))
    }
}
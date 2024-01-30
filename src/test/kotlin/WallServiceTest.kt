import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class WallServiceTest {

    @Test
    fun add() {
        val comments = Comment()
        val likes = Likes()
        var post = DataPost(like = likes, signer_id = null)
        val service = WallService()
        var commitPost = service.add(post)
        assertTrue(commitPost.id != post.id && commitPost.id != 0)
    }

    @Test
    fun updateSuccessful() {
        val likes = Likes()
        var post = DataPost(like = likes, signer_id = null)
        val service = WallService()
        service.add(post)
        var post2 = DataPost(like = likes, signer_id = null)
        service.add(post2)
        assertTrue(service.update(post2))

    }

    @Test
    fun updateUnSuccessful() {

        val likes = Likes()
        var post = DataPost(like = likes, signer_id = null)
        val service = WallService()
        service.add(post)
        var post2 = DataPost(like = likes, signer_id = null)
        service.add(post2)
        var post3 = DataPost(id = -2, like = likes, signer_id = null)
        assertFalse(service.update(post3))
    }
}
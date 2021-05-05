/**
 * https://leetcode.com/problems/design-twitter/submissions/
 */
class Twitter {
    
    Map<Integer, LinkedList<Tweet>> tweets;
    Map<Integer, Set<Integer>> followers;
    int currentTime;
    
    class Tweet {
        int id;
        int creationTime;
        
        public Tweet(int id, int creationTime) {
            this.id = id;
            this.creationTime = creationTime;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        tweets = new HashMap();
        followers = new HashMap();
        currentTime = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!followers.containsKey(userId)) {
            followers.put(userId, new HashSet());
        }
        followers.get(userId).add(userId);
        
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new LinkedList());
        }
        
        tweets.get(userId).addFirst(new Tweet(tweetId, currentTime));
        currentTime++;
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        if (!followers.containsKey(userId)) {
            return new LinkedList();
        }
        
        List<Integer> result = new LinkedList<>();
        PriorityQueue<Tweet> feed = new PriorityQueue<>((t1, t2) -> t2.creationTime - t1.creationTime);
        
        followers.get(userId).stream().filter(f -> tweets.containsKey(f)).forEach(f -> tweets.get(f).forEach(feed::add));
        
        while (feed.size() > 0 && result.size() < 10) {
            result.add(feed.poll().id);
        }
        
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!followers.containsKey(followerId)) {
            followers.put(followerId, new HashSet());
        }
        
        followers.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId) && followerId != followeeId) {
            followers.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
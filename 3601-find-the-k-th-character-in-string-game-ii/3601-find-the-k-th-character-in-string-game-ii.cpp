// recursive version
class Solution {
public:
    static char kthCharacter(long long k, vector<int>& operations, int b=63){
        if (b<0||k<=1) return 'a';
        const uint64_t B=1ULL<<b;
        return (k>B)?'a'+(operations[b]+(kthCharacter(k-B, operations, b-1)-'a'))%26:
        kthCharacter(k, operations, b-1);

    }
};
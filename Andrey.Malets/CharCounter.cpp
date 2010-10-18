#include <map>
#include <stdexcept>
#include <string>
#include <iostream>

template<typename Char> class Counter
{
private:
	std::map<Char,long> map;

public:
	template<typename I> void update(I begin, I end)
	{
		for(;begin!=end; begin++)
		{
			long count = 0;
			try
			{
				count = map.at(*begin);
				map.erase(map.find(*begin));
			}
			catch(std::out_of_range ex) { }
			map.insert(std::make_pair(*begin, count+1));
		}
	}

	const std::map<Char,long> &getState(void) const
	{
		return map;
	}

/*	void dump()
	{
		for(auto i = map.begin(); i != map.end(); i++)
			std::cout << i->first << ": " << i->second << std::endl;
	}
*/
};

int main(void)
{
	Counter<char> c;
	std::string s;
	std::cin >> s;
	c.update(s.begin(), s.end());
	const std::map<char,long> &state = c.getState();
	for(auto i = state.begin(); i != state.end(); i++)
		std::cout << i->first << ": " << i->second << std::endl;
}

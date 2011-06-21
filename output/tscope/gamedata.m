#import "gamedata.h"

static TranslationScope *translationScope;

@implementation gamedata

+ (TranslationScope *) translationScope
{	
	[GameData class];
	[PatrollingThreat class];
	[RepellableThreat class];
	[Threat class];
	[OrbitingThreat class];
	[Entity class];
	[SingleSeekerThreat class];

	if (translationScope == nil)
	{
		NSString *path = [[[NSBundle mainBundle] resourcePath] stringByAppendingPathComponent: @"gamedata.xml"];
		translationScope = [[TranslationScope alloc] initWithXMLFilePath: path];
	}
	return translationScope;
}

@end


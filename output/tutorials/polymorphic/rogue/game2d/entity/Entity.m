//
//  Entity.m
//  ecologylabXML
//
//  Generated by CocoaTranslator on 06/21/11.
//  Copyright 2011 Interface Ecology Lab. 
//

#import "Entity.h"

@implementation Entity

@synthesize m_id;
@synthesize online;
@synthesize m_in;
@synthesize safe;
@synthesize ord;
- (void) dealloc {
	[m_id release];
	[super dealloc];
}

- (void) setOnlineWithReference: (bool *) p_online {
	online = *p_online;
}

- (void) setM_inWithReference: (bool *) p_m_in {
	m_in = *p_m_in;
}

- (void) setSafeWithReference: (bool *) p_safe {
	safe = *p_safe;
}

- (void) setOrdWithReference: (int *) p_ord {
	ord = *p_ord;
}



@end


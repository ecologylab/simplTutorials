//
//  SingleSeekerThreat.m
//  ecologylabXML
//
//  Generated by CocoaTranslator on 09/12/11.
//  Copyright 2011 Interface Ecology Lab. 
//

#import "SingleSeekerThreat.h"

@implementation SingleSeekerThreat

@synthesize m_id;
@synthesize online;
@synthesize m_in;
@synthesize safe;
@synthesize ord;
@synthesize targetOrd;
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

- (void) setTargetOrdWithReference: (int *) p_targetOrd {
	targetOrd = *p_targetOrd;
}



@end


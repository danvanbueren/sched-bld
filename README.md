1. Load information from unknown source and parse into database ~~(flat file?)~~ (nope, we're using MySQL)
	- names/ranks, appointments + info
2. Ask user for sortie dates/times to be scheduled
3. Load each individual identity as an object & cross-check availability
4. Preset alibis & potential matches

(Add local rules if pex cannot be used to create certain containers, save these special cases to a local db)
(cache a copy of pex data just in case it cannot be retrieved again, i.e. pex is down)
